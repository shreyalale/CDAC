using System;
using System.IO;

namespace FileLibrary
{
    public class FileHelper : IDisposable
    {
        private StreamWriter _logWriter;

        public FileHelper()
        {
            _logWriter = new StreamWriter("Notes.txt", append: true);
        }

        public void MoveFile(string sourceFilePath, string destinationDirectory)
        {
            try
            {
                string fileName = Path.GetFileName(sourceFilePath);
                string destinationFilePath = Path.Combine(destinationDirectory, fileName);

                if (!Directory.Exists(destinationDirectory))
                {
                    Directory.CreateDirectory(destinationDirectory);
                }

                File.Move(sourceFilePath, destinationFilePath);
                LogActivity($"Moved file from {sourceFilePath} to {destinationFilePath}");
            }
            catch (Exception ex)
            {
                LogActivity($"Error moving file: {ex.Message}");
            }
        }

        public void DeleteFile(string filePath)
        {
            try
            {
                File.Delete(filePath);
                LogActivity($"Deleted file: {filePath}");
            }
            catch (Exception ex)
            {
                LogActivity($"Error deleting file: {ex.Message}");
            }
        }

        public string GetFileInfo(string filePath)
        {
            try
            {
                var fileInfo = new FileInfo(filePath);
                return $"File Name: {fileInfo.Name}, Size: {fileInfo.Length / 1024.0:F2} KB, Created: {fileInfo.CreationTime}";
            }
            catch (Exception ex)
            {
                return $"Error getting file info for {filePath}. Details: {ex.Message}";
            }
        }

        ~FileHelper()
        {
            Dispose();
        }

        // Log cleanup activities
        private void LogActivity(string message)
        {
            if (_logWriter != null)
            {
                _logWriter.WriteLine($"{DateTime.Now}: {message}");
            }
        }

        public void Dispose()
        {
            if (_logWriter != null)
            {
                _logWriter.Dispose();
                _logWriter = null;
            }
        }
    }
}
