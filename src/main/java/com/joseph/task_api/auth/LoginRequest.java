package com.joseph.task_api.auth;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}