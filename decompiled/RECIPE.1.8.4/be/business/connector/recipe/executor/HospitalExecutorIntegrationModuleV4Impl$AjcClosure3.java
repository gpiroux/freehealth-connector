package be.business.connector.recipe.executor;

import be.recipe.services.executor.ListRidsHistoryParam;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.AroundClosure;

public class HospitalExecutorIntegrationModuleV4Impl$AjcClosure3 extends AroundClosure {
   public HospitalExecutorIntegrationModuleV4Impl$AjcClosure3(Object[] var1) {
      super(var1);
   }

   public Object run(Object[] var1) {
      Object[] var2 = super.state;
      return HospitalExecutorIntegrationModuleV4Impl.getData_aroundBody2((HospitalExecutorIntegrationModuleV4Impl)var2[0], (ListRidsHistoryParam)var2[1], (JoinPoint)var2[2]);
   }
}
