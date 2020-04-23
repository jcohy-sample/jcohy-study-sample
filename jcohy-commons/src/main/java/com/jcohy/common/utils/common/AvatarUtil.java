package com.jcohy.common.utils.common;

public final class AvatarUtil {

    public static String randomAvatar(String prefix, String seed){
        if (StringUtils.isBlank(seed)){
            return null;
        } else {
            return prefix + "t_" + (Math.abs(seed.hashCode()) % 16 + 1) + ".png";
        }
    }
}
