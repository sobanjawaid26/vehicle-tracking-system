package com.sobanscode.group.data.repository;

import com.sobanscode.group.data.entity.Group;
import com.sobanscode.group.data.entity.GroupToGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface IGroupToGroupRepository extends JpaRepository<GroupToGroup, Long> {
    @Query("SELECT g.id, g.name, g.company, g.root FROM GroupToGroup g2g, Group g WHERE g2g.childGroup.id = :childId and g2g.parentGroup.id = g.id")
    Group findParent(@Param("childId") Long childId);
    @Query("SELECT g.id, g.name, g.company, g.root FROM GroupToGroup g2g, Group g WHERE g2g.parentGroup.id = :parentId and g2g.childGroup.id = g.id")
    Set<Group> findAllByParentGroup(@Param("parentId") Long parentId);

    Optional<GroupToGroup> findByChildGroup(Group childGroup);

    int deleteByParentGroupAndChildGroup(Group parentGroup, Group childGroup);

    void deleteByParentGroupIdOrChildGroupId(long groupId, long groupId2);
}
