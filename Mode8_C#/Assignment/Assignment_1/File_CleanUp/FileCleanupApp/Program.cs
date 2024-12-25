using System;
using System.IO;
using FileLibrary; // Ensure this matches your actual FileHelper namespace

class Program
{
    static void Main()
    {
        Console.WriteLine("File Cleanup Utility");

        // Accept the directory path
        Console.Write("Enter the directory path: ");
        string directoryPath = Console.ReadLine();

        // Check if the directory exists
        if (!Directory.Exists(directoryPath))
        {
            Console.WriteLine("Directory does not exist.");
            return;
        }

        // Accept file extension
        Console.Write("Enter the file extension to clean up (e.g., .txt, .jpg): ");
        string fileExtension = Console.ReadLine();

        if (string.IsNullOrWhiteSpace(fileExtension) || !fileExtension.StartsWith("."))
        {
            Console.WriteLine("Invalid file extension.");
            return;
        }

        // Accept destination directory
        Console.Write("Enter the destination directory for the files: ");
        string destinationDirectory = Console.ReadLine();

        // Create the destination directory if it doesn't exist
        if (!Directory.Exists(destinationDirectory))
        {
            Directory.CreateDirectory(destinationDirectory);
        }

        // File cleanup process
        using (var fileHelper = new FileHelper())
        {
            try
            {
                var files = Directory.GetFiles(directoryPath, $"*{fileExtension}");

                if (files.Length == 0)
                {
                    Console.WriteLine($"No files with extension {fileExtension} found in the directory.");
                }
                else
                {
                    foreach (var file in files)
                    {
                        Console.WriteLine(fileHelper.GetFileInfo(file));
                        fileHelper.MoveFile(file, destinationDirectory);
                    }

                    Console.WriteLine("File cleanup completed.");
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error: {ex.Message}");
            }
        }
    }
}
