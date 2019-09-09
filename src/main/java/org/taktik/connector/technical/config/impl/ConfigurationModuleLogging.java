package org.taktik.connector.technical.config.impl;

import org.taktik.connector.technical.config.ConfigFactory;
import org.taktik.connector.technical.config.Configuration;
import org.taktik.connector.technical.config.ConfigurationModule;
import org.taktik.connector.technical.exception.TechnicalConnectorException;
import java.lang.reflect.Method;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ConfigurationModuleLogging implements ConfigurationModule {
   private static final Logger LOG = LoggerFactory.getLogger(ConfigurationModuleLogging.class);
   private static final String PROP_LOG_ENABLED = "connector.logger.enabled";
   private static final boolean PROP_LOG_ENABLED_DEFAULT = true;
   private static final String PROP_LOG_FRAMEWORK_CLASS = "connector.logger.framework";
   private static final String PROP_LOG_FRAMEWORK_DEFAULT = "org.taktik.connector.technical.config.impl.ConfigurationModuleLoggingLog4j";
   private Object logger;

   public void init(Configuration config) {
      LOG.debug("Initializing ConfigurationModule " + this.getClass().getName());
      if (!config.getBooleanProperty("connector.logger.enabled", true)) {
         LOG.debug("ConfigurationModuleLogging is disabled.");
      } else if (config instanceof ConfigurationImpl) {
         ConfigurationImpl conf = (ConfigurationImpl)config;
         String className = config.getProperty("connector.logger.framework", "org.taktik.connector.technical.config.impl.ConfigurationModuleLoggingLog4j");

         try {
            Class loggerClass = Class.forName(className);
            this.logger = loggerClass.newInstance();
            Method method = loggerClass.getDeclaredMethod("init", Properties.class);
            method.invoke(this.logger, conf.getProperties());
         } catch (Exception var6) {
            LOG.error(var6.getClass().getSimpleName() + ": " + var6.getMessage());
         }
      } else {
         LOG.warn("Unsupported config instance: " + config.getClass());
      }

   }

   public void unload() throws TechnicalConnectorException {
      if (ConfigFactory.getConfigValidator().getBooleanProperty("connector.configurationmodule.logger.unload", false)) {
      LOG.debug("Unloading ConfigurationModule " + this.getClass().getName());

      try {
         Method method = this.logger.getClass().getDeclaredMethod("unload");
         method.invoke(this.logger);
      } catch (Exception var2) {
         LOG.error(var2.getClass().getSimpleName() + ": " + var2.getMessage());
      }
      }

   }
}
