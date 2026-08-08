/* Copyright 2026 上海如静知华信息科技有限公司 */
import {defineStore} from 'pinia'; import http from '../api/http'; import {domain} from '../config/domain'
const TOKEN_KEY='zhuatech-procureagent-token',USER_KEY='zhuatech-procureagent-user'
export const useAuthStore=defineStore('auth',{state:()=>({user:JSON.parse(localStorage.getItem(USER_KEY)||'null')}),actions:{async login(username,password){let data;if(import.meta.env.VITE_DEMO_MODE==='true'){const operator=username==='operator';data={token:'demo-token',user:{username,fullName:operator?domain.fieldUser:domain.adminUser,role:operator?'DOMAIN_USER':'DOMAIN_OPERATOR',operatingUnitCode:operator?'DEMO-UNIT':null}}}else{data=(await http.post('/auth/login',{username,password})).data.data}this.user=data.user;localStorage.setItem(TOKEN_KEY,data.token);localStorage.setItem(USER_KEY,JSON.stringify(data.user));return data.user},logout(){this.user=null;localStorage.removeItem(TOKEN_KEY);localStorage.removeItem(USER_KEY)}}})

