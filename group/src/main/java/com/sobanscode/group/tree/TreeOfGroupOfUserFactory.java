package com.sobanscode.group.tree;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TreeOfGroupOfUserFactory {

    private final ApplicationContext applicationContext;


    public TreeOfGroupOfUserFactory(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public TreeOfGroupOfUser createTreeOfGroupOfUser(String generalRequestHeader){
        TreeOfGroupOfUser treeOfGroupOfUser = applicationContext.getBean(TreeOfGroupOfUser.class);
        treeOfGroupOfUser.setGeneralRequestHeader(generalRequestHeader);
        return treeOfGroupOfUser;
    }
}
