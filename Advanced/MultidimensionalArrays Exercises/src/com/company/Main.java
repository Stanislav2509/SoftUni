package com.company;

public class Main {

    public static void main(String[] args) {
	//  private static int[,] RemoveEmptyCells(int[,] matrix)
        //        {
        //            // push empty cols to the end
        //            for (int i = 0; i < matrix.GetLength(0); i++)
        //            {
        //                Queue<int> currentRow = new Queue<int>();
        //                for (int j = 0; j < matrix.GetLength(1); j++)
        //                {
        //                    if (matrix[i, j] != 0)
        //                    {
        //                        currentRow.Enqueue(matrix[i, j]);
        //                    }
        //                }
        //
        //                for (int j = 0; j < matrix.GetLength(1); j++)
        //                {
        //                    if (currentRow.Count > 0)
        //                    {
        //                        matrix[i, j] = currentRow.Dequeue();
        //                    }
        //                    else
        //                    {
        //                        matrix[i, j] = 0;
        //                    }
        //                }
        //            }
        //
        //            // check for empty rows and remove them
        //            List<int> emptyRowsIndexes = new List<int>();
        //            for (int i = 0; i < matrix.GetLength(0); i++)
        //            {
        //                for (int j = 0; j < matrix.GetLength(1); j++)
        //                {
        //                    // if you find non-empty element go to next row
        //                    if (matrix[i, j] != 0)
        //                    {
        //                        break;
        //                    }
        //
        //                    // if that's the last element and it's 0, then the row is empty, save the index
        //                    if (j == matrix.GetLength(1) - 1 && matrix[i, j] == 0)
        //                    {
        //                        emptyRowsIndexes.Add(i);
        //                    }
        //                }
        //            }
        //
        //            if (emptyRowsIndexes.Count == 0)
        //            {
        //                return matrix;
        //            }
        //            else
        //            {
        //                int reducedMatrixrows = matrix.GetLength(0) - emptyRowsIndexes.Count;
        //                int reducedMatrixCols = matrix.GetLength(1);
        //                int[,] reducedMatrix = new int[reducedMatrixrows, reducedMatrixCols];
        //
        //                int reducedMatrixRow = 0;
        //                for (int i = 0; i < matrix.GetLength(0); i++)
        //                {
        //                    if (emptyRowsIndexes.Contains(i))
        //                    {
        //                        continue;
        //                    }
        //
        //                    int reducedMatrixCol = 0;
        //                    for (int j = 0; j < matrix.GetLength(1); j++)
        //                    {
        //                        reducedMatrix[reducedMatrixRow, reducedMatrixCol] = matrix[i, j];
        //                        reducedMatrixCol++;
        //                    }
        //
        //                    reducedMatrixRow++;
        //                }
        //
        //                return reducedMatrix;
        //            }
        //        }
    }
}
