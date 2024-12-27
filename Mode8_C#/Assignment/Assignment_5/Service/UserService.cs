using userRegister.Models;

namespace userRegister.Service
{
    public class UserService
    {
        private readonly IUserRepository _userRepository;

        public UserService(IUserRepository userRepository)
        {
            _userRepository = userRepository;
        }

        public bool Validate(string email, string password)
        {
            return _userRepository.Validate(email, password);
        }

        public bool Register(User user)
        {
            return _userRepository.Insert(user);
        }
    }
}
