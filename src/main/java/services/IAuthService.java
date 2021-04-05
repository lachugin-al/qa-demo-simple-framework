package services;

import models.api.User;

public interface IAuthService extends IBasicService {
    User createUser(User user);
    User login(User user);
}
