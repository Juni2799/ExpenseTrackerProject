package dev.akshaan.ExpenseTracker.mapper;

import dev.akshaan.ExpenseTracker.dtos.GroupResponseDTO;
import dev.akshaan.ExpenseTracker.dtos.UserFriendResponseDTO;
import dev.akshaan.ExpenseTracker.dtos.UserLoginResponseDTO;
import dev.akshaan.ExpenseTracker.models.Group;
import dev.akshaan.ExpenseTracker.models.User;

import java.util.ArrayList;
import java.util.List;

public class EntityDTOMapper {
    public static UserLoginResponseDTO toDTO(User user){
        UserLoginResponseDTO userLoginResponseDTO = new UserLoginResponseDTO();
        userLoginResponseDTO.setId(user.getId());
        userLoginResponseDTO.setName(user.getName());
        userLoginResponseDTO.setEmail(user.getEmail());

        List<UserFriendResponseDTO> friendList = new ArrayList<>();
        if(user.getFriends() != null){
            for(User friend: user.getFriends()){
                friendList.add(toFriendDTO(friend));
            }
            userLoginResponseDTO.setFriendList(friendList);
        }

        List<GroupResponseDTO> groups = new ArrayList<>();
        if(user.getGroups() != null){
            for(Group group: user.getGroups()){
                groups.add(toGroupDTO(group));
            }
            userLoginResponseDTO.setGroups(groups);
        }

        return userLoginResponseDTO;
    }

    private static UserFriendResponseDTO toFriendDTO(User friend){
        UserFriendResponseDTO userFriendResponseDTO = new UserFriendResponseDTO();
        userFriendResponseDTO.setId(friend.getId());
        userFriendResponseDTO.setName(friend.getName());
        return userFriendResponseDTO;
    }

    private static GroupResponseDTO toGroupDTO(Group group){
        GroupResponseDTO groupResponseDTO = new GroupResponseDTO();
        groupResponseDTO.setId(group.getId());
        groupResponseDTO.setName(group.getName());
        return groupResponseDTO;
    }
}
