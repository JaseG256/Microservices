package com.Msa.contentmanagementsystem.vo;

import com.Msa.contentmanagementsystem.model.Role;
import lombok.Data;

@Data

public class UserRequest {

    String identity;

    String name;

    Role role;
}
