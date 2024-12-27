namespace userRegister.Models
{
    public interface IUserRepository
    {
        bool Validate(string email, string password);
        bool Insert(User user);
    
    }
}
