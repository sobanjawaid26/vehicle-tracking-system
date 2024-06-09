package com.sobanscode.group.data.dal;

import com.sobanscode.group.data.repository.*;
import org.springframework.stereotype.Component;

@Component
public class GroupServiceHelper {

    private final IGroupToGroupRepository groupToGroupRepository;
    private final IGroupRepository groupRepository;
    private final IUserGroupAuthRepository userGroupAuthRepository;

    public GroupServiceHelper(IGroupToGroupRepository groupToGroupRepository, IGroupRepository groupRepository, IUserGroupAuthRepository userGroupAuthRepository) {
        this.groupToGroupRepository = groupToGroupRepository;
        this.groupRepository = groupRepository;
        this.userGroupAuthRepository = userGroupAuthRepository;
    }

}
