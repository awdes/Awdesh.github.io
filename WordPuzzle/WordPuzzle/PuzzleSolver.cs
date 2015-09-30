using System;
using System.Collections.Generic;
using System.IO;
using System.Text;

namespace WordPuzzle
{
    /// <summary>
    /// Puzzle Solver class responsible for storing words in a dictionary
    /// and then search in it from all possible direction around the word.
    /// </summary>
    static class PuzzleSolver
    {
        // Using OrdinalIgnoreCase in order to search all words.
        static Dictionary<string, WordType> _words = new Dictionary<string, WordType>(10000, StringComparer.OrdinalIgnoreCase);
        static Dictionary<string, bool> _found = new Dictionary<string, bool>(StringComparer.OrdinalIgnoreCase);
        const int _minLength = 3; // Minimum length of matching words.
        const string _pattern = @"catdogead";

        /// <summary>
        /// 
        /// </summary>
        public static void Solve()
        {
            StoreData();
            SearchWord();
        }

        /// <summary>
        /// 
        /// </summary>
        private static void StoreData()
        {
            // Read in dictionary.
            using (StreamReader reader = new StreamReader("File.txt"))
            {
                while (true)
                {
                    string line = reader.ReadLine();
                    if (line == null)
                    {
                        break;
                    }
                    if (line.Length >= _minLength)
                    {
                        for (int i = 1; i <= line.Length; i++)
                        {
                            string substring = line.Substring(0, i);
                            WordType value;
                            if (_words.TryGetValue(substring, out value))
                            {
                                // If this is a full word.
                                if (i == line.Length)
                                {
                                    // If only partial word is stored.
                                    if (value == WordType.PartialWord)
                                    {
                                        // Upgrade type.
                                        _words[substring] = WordType.FullWordAndPartialWord;
                                    }
                                }
                                else
                                {
                                    // If not a full word and only partial word is stored.
                                    if (value == WordType.FullWord)
                                    {
                                        _words[substring] = WordType.FullWordAndPartialWord;
                                    }
                                }
                            }
                            else
                            {
                                // If this is a full word.
                                if (i == line.Length)
                                {
                                    _words.Add(substring, WordType.FullWord);
                                }
                                else
                                {
                                    _words.Add(substring, WordType.PartialWord);
                                }
                            }
                        }
                    }
                }
            }

            Console.WriteLine("[Read completed]");
        }

        const int MIN_LENGTH = 3;

        /// <summary>
        /// Open the "WordSearch.txt" file and search create a 2D array with all the letters of the words.
        /// </summary>
        private static void SearchWord()
        {
            using (StreamReader reader = new StreamReader("File.txt"))
            {
                while (true)
                {
                    string[] lines = File.ReadAllLines("File.txt");
                    if (lines.Length <= 0)
                    {
                        break;
                    }
                    // Put into 2D array.
                    int x = lines.Length;
                    int y = lines[0].Length;
                    char[,] array = new char[x, y];
                    for (int i = 0; i < y; i++)
                    {
                        for (int a = 0; a < x; a++)
                        {
                            array[a, i] = lines[a][i];
                        }
                    }
                    // Start at each square in the 2D array.
                    for (int i = 0; i < x; i++)
                    {
                        for (int a = 0; a < x; a++)
                        {
                            // Search all directions.
                            for (int d = 0; d < 8; d++)
                            {
                                SearchAt(array, i, a, y, x, "", d);
                            }
                        }
                    }

                    Console.WriteLine("[Search completed]");
                    Console.ReadLine();
                }
            }
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="array"></param>
        /// <param name="i"></param>
        /// <param name="a"></param>
        /// <param name="width"></param>
        /// <param name="height"></param>
        /// <param name="build"></param>
        /// <param name="direction"></param>
        private static void SearchAt(char[,] array, int i, int a, int width, int height, string build, int direction)
        {
            // Don't go past around array bounds.
            if (i >= width || i < 0 || a >= height || a < 0)
            {
                return;
            }
            // Get letter.
            char letter = array[a, i];
            // Append.
            string pass = build + letter;
            // See if full word.
            WordType value;
            if (_words.TryGetValue(pass, out value))
            {
                // Handle all full words.
                if (value == WordType.FullWord ||
                value == WordType.FullWordAndPartialWord)
                {
                    // Don't display same word twice.
                    if (!_found.ContainsKey(pass))
                    {
                        Console.WriteLine("{0} found", pass);
                        _found.Add(pass, true);
                    }
                }
                // Handle all partial words.
                if (value == WordType.PartialWord ||
                value == WordType.FullWordAndPartialWord)
                {
                    // Continue in one direction.
                    switch (direction)
                    {
                        case 0:
                            SearchAt(array, i + 1, a, width, height, pass, direction);
                            break;
                        case 1:
                            SearchAt(array, i, a + 1, width, height, pass, direction);
                            break;
                        case 2:
                            SearchAt(array, i + 1, a + 1, width, height, pass, direction);
                            break;
                        case 3:
                            SearchAt(array, i - 1, a, width, height, pass, direction);
                            break;
                        case 4:
                            SearchAt(array, i, a - 1, width, height, pass, direction);
                            break;
                        case 5:
                            SearchAt(array, i - 1, a - 1, width, height, pass, direction);
                            break;
                        case 6:
                            SearchAt(array, i - 1, a + 1, width, height, pass, direction);
                            break;
                        case 7:
                            SearchAt(array, i + 1, a - 1, width, height, pass, direction);
                            break;
                    }
                }
            }
        }
    }
}
