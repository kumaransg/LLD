package model;

import lombok.Builder;
import lombok.Value;
import model.common.Contact;
import model.common.PersonalInfo;
import model.common.SocialInfo;
import model.common.Tag;

import java.time.LocalDateTime;

@Value
@Builder
public class Account {
    private String id;
    private String phoneNumber;
    private String username;
    private String password;
    private LocalDateTime lastAccessed;
    private Tag tag;
    private Contact contact;
    private PersonalInfo personalInfo;
    private SocialInfo socialInfo;

}
