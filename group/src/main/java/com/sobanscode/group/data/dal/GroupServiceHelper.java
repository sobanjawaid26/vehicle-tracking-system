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

    //TODO saveGroup
    //TODO saveUserGroupAuth
    //TODO getGroupByIdAndCompanyId
    //TODO saveGroupToGroup
    //TODO getChildren
    //TODO getUserGroupAuth
    //TODO findRootGroupsByCompanyId
    //TODO getParent
    //TODO deleteGroupToGroup
    //TODO deleteGroupToGroupByParentIdOrChildId
    //TODO deleteGroup
    //TODO deleteUserGroupAuthByGroupId
}
