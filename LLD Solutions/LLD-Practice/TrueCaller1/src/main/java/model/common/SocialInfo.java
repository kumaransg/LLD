package model.common;

import lombok.Builder;
import lombok.Value;

import java.util.HashMap;
import java.util.Map;

@Value
@Builder
public class SocialInfo {
    private Map<SocialProfileType,String> socialInfo= new HashMap<>();
}
