package com.group.jjabflix.profile.dao;

import com.group.jjabflix.profile.dto.ProfileRequestDto;
import com.group.jjabflix.profile.vo.Profile;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProfileMapper {

    void insertProfile(ProfileRequestDto profile);

    Profile selectProfile(Long profileId);

    List<Profile> selectProfiles(Long userId);

    int isProfileNameExist(ProfileRequestDto profile);
    Long getProfileId(ProfileRequestDto profile);

}
