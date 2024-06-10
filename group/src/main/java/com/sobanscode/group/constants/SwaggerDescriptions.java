package com.sobanscode.group.constants;

public interface SwaggerDescriptions {
    String DESCRIPTION1 = "Endpoint that registers a new group. If root=true, it ignores parentId. If root=false, it takes parentId into account.";
    String DESCRIPTION2 = "The endpoint that authorizes the user to the group. If the user wants to be authorized to a group in which he/she is authorized, conflict is returned. When a user is authorized to a group, he/she automatically becomes authorized to all children of that group. In other words, separate authorization records for each user are not kept for each group. While creating a group tree, the groups to which the user is authorized are kept in the tree structure.";
    String DESCRIPTION3 = "The endpoint, which rotates in the tree structure with the groups to which the user is authorized, along with the tools in the group, does not include the tools to which the user is directly authorized.";
    String DESCRIPTION4 = "The endpoint, which returns the list structure of the vehicles to which the user is authorized, also includes the vehicles to which the user is directly authorized.";
    String DESCRIPTION5 = "The endpoint returned in the list structure of the vehicles authorized by the user given with userId. Only company admins can use it";
    String DESCRIPTION6 = "Endpoint returning the groups to which the user is authorized in a list structure";
    String DESCRIPTION7 = "Endpoint, which returns the groups to which the user is authorized in the list structure, is the endpoint that deletes the group. Deletion of root groups is not allowed. When you want to delete a group, the tools in the group are moved under the parent of the deleted group. In addition, all children of the deleted group are now children of the parent group. Only company admins can use it. All authority records in the database related to the deleted group are deleted.";
}
