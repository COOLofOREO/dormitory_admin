package com.server.entity;

import com.server.dto.UserAll;
import lombok.Data;

import java.io.Serializable;
@Data
public class Administrator extends UserAll implements Serializable {
    private String employeeId;
}
