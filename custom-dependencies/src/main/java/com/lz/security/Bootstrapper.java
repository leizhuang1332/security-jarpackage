package com.lz.security;

import com.lz.security.entity.inteface.RolePermissionSecurityEntityInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 启动加载器
 * 加载需要的初始化数据
 */
@Component
public class Bootstrapper implements CommandLineRunner {

    private Logger log = LoggerFactory.getLogger(Bootstrapper.class);

    /**
     * 角色权限
     * <权限: Collection<角色>>
     */
    public static Map<String, Collection<ConfigAttribute>> ROLE_AUTHORITY_MAP = new HashMap<>();

    @Override
    public void run(String... args) throws Exception {
        loadAuthority();
    }

    /**
     * 加载授权
     */
    public void loadAuthority() {
        // 查询角色权限表
        List<? extends RolePermissionSecurityEntityInterface> all = AuthenticationAdapter.getInstance().getRolePermissionService().getAll();
        Map<String, List<RolePermissionSecurityEntityInterface>> collect = all.stream().collect(Collectors.groupingBy(RolePermissionSecurityEntityInterface::getPermissionUrl));
        for (Map.Entry<String, List<RolePermissionSecurityEntityInterface>> entry : collect.entrySet()) {

            String key = entry.getKey();
            List<RolePermissionSecurityEntityInterface> value = entry.getValue();

            Collection<ConfigAttribute> configAttributes = new ArrayList<>();
            for (RolePermissionSecurityEntityInterface rolePermissionSecurityEntityInterface : value) {
                ConfigAttribute configAttribute = new SecurityConfig(rolePermissionSecurityEntityInterface.getRoleEnname());
                configAttributes.add(configAttribute);
            }
            ROLE_AUTHORITY_MAP.put(key, configAttributes);
        }
        log.info("初始化加载授权 --- {}", ROLE_AUTHORITY_MAP);
    }
}
