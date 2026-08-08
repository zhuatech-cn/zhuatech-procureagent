# ProcureAgent API

© 2026 上海如静知华信息科技有限公司

统一响应结构为 success、message、data、timestamp。除登录外，业务接口使用 Bearer JWT；演示账号仅用于本地环境。

| 方法 | 路径 | 说明 |
| --- | --- | --- |
| POST | /api/auth/login | 登录并获取访问令牌 |
| GET | /api/admin/dashboard | 管理端运营总览 |
| GET | /api/admin/work-orders | 业务协同队列 |
| GET | /api/shopfloor/dashboard | 业务用户工作台 |
| POST | /api/shopfloor/work-orders/{id}/reports | 提交人工确认结果 |
| POST | /api/shopfloor/agent-preview | 执行本地 Agent 演示流程 |
| POST | /api/shopfloor/bid-evaluation | 执行领域规则检查 |

请求校验失败返回 400；认证失败返回 401/403；业务异常返回可读错误信息。生产环境应接入企业统一身份、审计与密钥管理。

