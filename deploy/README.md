# ProcureAgent 部署指南

© 2026 上海如静知华信息科技有限公司

## 演示界面

    cd frontend
    npm install
    npm run dev:demo

## 完整环境

复制 .env.example 为 .env，修改 MySQL 密码与 JWT 密钥后执行 docker compose up --build。不得直接使用示例密码部署到公网。

服务默认端口：前端 8080、Java API 8088、MySQL 3306。生产环境应使用 HTTPS、外部密钥管理、数据库备份、限流、监控和最小权限网络策略。

