/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.procureagent.agent;
import org.springframework.stereotype.Component; import java.util.List; import java.util.Map;
/** 企业采购智能体协同平台运行边界；默认演示执行器不连接真实模型、业务系统或外部通信渠道。 */
public interface AgentRuntime {
 AgentResult run(AgentRequest request);
 record AgentRequest(String objective,Map<String,String> context){}
 record AgentStep(String name,String status,String evidence){}
 record AgentResult(String runtime,String summary,List<AgentStep> steps,Map<String,Object> metrics){}
}
@Component class DemoAgentRuntime implements AgentRuntime {
 public AgentResult run(AgentRequest request){
  return new AgentResult("procure-evidence-demo","已完成供应市场和报价证据整理，推荐排序与谈判边界等待采购负责人确认。",List.of(new AgentStep("供应市场研究","COMPLETED","关联 8 家候选供应商"),new AgentStep("多维比价","COMPLETED","对照价格、条款与履约能力"),new AgentStep("定标建议","PENDING","等待采购委员会确认")),Map.of("evidenceItems",12,"suggestedActions",3,"objectiveLength",request.objective().length()));
 }
}

