package com.lamri.werewolfbe.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class WardDTO implements Serializable {

    String wardId;
    String name;
}
