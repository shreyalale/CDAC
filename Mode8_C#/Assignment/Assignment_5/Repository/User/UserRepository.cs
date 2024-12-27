using System.Data;
using System.Security.Cryptography.X509Certificates;
using MySql.Data.MySqlClient;
namespace userRegister.Models;

using MySql.Data.MySqlClient;
using System.Data;

public class UserRepository : IUserRepository
{
    private readonly string _connectionString;

    public UserRepository(string connectionString)
    {
        _connectionString = connectionString;
    }

    public bool Validate(string email, string password)
    {
        using (var connection = new MySqlConnection(_connectionString))
        {
            connection.Open();
            string query = "SELECT COUNT(*) FROM Users WHERE Email = @Email AND Password = @Password";
            using (var cmd = new MySqlCommand(query, connection))
            {
                cmd.Parameters.AddWithValue("@Email", email);
                cmd.Parameters.AddWithValue("@Password", password);
                return Convert.ToInt32(cmd.ExecuteScalar()) > 0;
            }
        }
    }

    public bool Insert(User user)
    {
        using (var connection = new MySqlConnection(_connectionString))
        {
            connection.Open();
            string query = "INSERT INTO Users (FirstName, LastName, Email, Contact, Password) VALUES (@FirstName, @LastName, @Email, @Contact, @Password)";
            using (var cmd = new MySqlCommand(query, connection))
            {
                cmd.Parameters.AddWithValue("@FirstName", user.FirstName);
                cmd.Parameters.AddWithValue("@LastName", user.LastName);
                cmd.Parameters.AddWithValue("@Email", user.Email);
                cmd.Parameters.AddWithValue("@Contact", user.Contact);
                cmd.Parameters.AddWithValue("@Password", user.Password);
                return cmd.ExecuteNonQuery() > 0;
            }
        }
    }
}
    