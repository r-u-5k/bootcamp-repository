package com.springboot.security.oauth.auth;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.springboot.security.oauth.auth.userinfo.Oauth2UserInfo;
import com.springboot.security.oauth.domain.entity.Member;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class PrincipalDetails implements UserDetails, OAuth2User {

    private Member member;
    private Oauth2UserInfo oauth2UserInfo;
    @Setter
    private List<Long> itemIdList = null;

    //form로그인 시 사용
    public PrincipalDetails(Member member) {
        this.member = member;
    }

    //Oauth2로그인 시 사용
    public PrincipalDetails(Member member, Oauth2UserInfo oauth2UserInfo) {
        this.member = member;
        this.oauth2UserInfo = oauth2UserInfo;
    }

    /**
     * UserDetails 구현
     * 해당 유저의 권한목록 리턴
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return member.getRole().toString();
            }
        });
        return collect;
    }


    /**
     * UserDetails 구현
     * 비밀번호를 리턴
     */
    @Override
    public String getPassword() {
        return member.getPassword();
    }


    /**
     * UserDetails 구현
     * PK값을 반환해준다
     */
    @Override
    public String getUsername() {
        return member.getEmail();
    }


    /**
     * UserDetails 구현
     * 계정 만료 여부
     * true : 만료안됨
     * false : 만료됨
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    /**
     * UserDetails 구현
     * 계정 잠김 여부
     * true : 잠기지 않음
     * false : 잠김
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    /**
     * UserDetails 구현
     * 계정 비밀번호 만료 여부
     * true : 만료 안됨
     * false : 만료됨
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    /**
     * UserDetails 구현
     * 계정 활성화 여부
     * true : 활성화됨
     * false : 활성화 안됨
     */
    @Override
    public boolean isEnabled() {
        return true;
    }


    /**
     * OAuth2User 구현
     *
     * @return
     */
    @Override
    public Map<String, Object> getAttributes() {
        return oauth2UserInfo.getAttributes();
    }

    /**
     * OAuth2User 구현
     *
     * @return
     */
    @Override
    public String getName() {
        return oauth2UserInfo.getProviderId();
    }
}
