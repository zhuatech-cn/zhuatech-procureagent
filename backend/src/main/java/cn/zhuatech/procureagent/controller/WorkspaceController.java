/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.procureagent.controller;
import cn.zhuatech.procureagent.agent.AgentRuntime;
import cn.zhuatech.procureagent.common.ApiResponse;
import cn.zhuatech.procureagent.dto.ProcureAgentDto.*;
import cn.zhuatech.procureagent.service.ProcureAgentService;
import cn.zhuatech.procureagent.service.BidEvaluationService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController @RequestMapping("/api/shopfloor") @PreAuthorize("hasAnyRole('DOMAIN_USER','ADMIN')")
public class WorkspaceController {
 private final ProcureAgentService service; private final AgentRuntime runtime; private final BidEvaluationService domainAgent;
 public WorkspaceController(ProcureAgentService service,AgentRuntime runtime,BidEvaluationService domainAgent){this.service=service;this.runtime=runtime;this.domainAgent=domainAgent;}
 @GetMapping("/dashboard") public ApiResponse<Dashboard> dashboard(){return ApiResponse.ok(service.shopfloorDashboard());}
 @PostMapping("/work-orders/{id}/reports") public ApiResponse<ReportResult> report(@PathVariable Long id,@Valid @RequestBody ReportRequest request){return ApiResponse.ok("反馈提交成功",service.report(id,request));}
 @PostMapping("/agent-preview") public ApiResponse<AgentRuntime.AgentResult> preview(@RequestBody Map<String,String> body){return ApiResponse.ok(runtime.run(new AgentRuntime.AgentRequest(body.getOrDefault("objective","分析当前业务事项"),Map.of("mode","demo","approval","required"))));}
 @PostMapping("/bid-evaluation") public ApiResponse<BidEvaluationService.BidResult> domainAction(@Valid @RequestBody BidEvaluationService.BidRequest request){return ApiResponse.ok("供应商评估完成",domainAgent.evaluate(request));}
}

