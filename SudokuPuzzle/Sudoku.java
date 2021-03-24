public class Sudoku {


    public static void main(String args[]){

        int  board[][]={
                {7,8,0,4,0,0,1,2,0},
                {6,0,0,0,7,5,0,0,9},
                {0,0,0,6,0,1,0,7,8},
                {0,0,7,0,4,0,2,6,0},
                {0,0,1,0,5,0,9,3,0},
                {9,0,4,0,6,0,0,0,5},
                {0,7,0,3,0,0,0,1,2},
                {1,2,0,0,0,7,4,0,0},
                {0,4,9,2,0,6,0,0,7}
        };


        System.out.println("SUDOKU PUZZLE!!!!!!");
             sudokuPrint(board);
             System.out.println("**********************");
                System.out.println("SOLVED SUDOKU PUZZLE!!!!!!");
              solve(board);
              sudokuPrint(board);
    }

       /// This function is use for filling the possible value in empty cell and if possible value is not valid the backTrack.
         public static boolean solve(int board[][]){


            int rowAndcol[]=findEmpty(board);

                if(rowAndcol[0]==-1 && rowAndcol[1]==-1)
                      return true;

                      for(int i=1;i<=9;++i){
                          if(valid(board,i,rowAndcol)) {
                              board[rowAndcol[0]][rowAndcol[1]] = i;
                              if(solve(board))
                                  return true;
                              board[rowAndcol[0]][rowAndcol[1]]=0;

                          }

                      }

                 return  false;

         }

         public static  boolean valid(int board[][],int num,int rowAndcol[]){

             /// Below code is use for checking for num value is present or not in perticular column.

                 for(int i=0;i< board[0].length;++i){
                        if(board[rowAndcol[0]][i]==num && rowAndcol[1]!=i)
                               return false;
                 }

           ////  Below code is use for checking for num value is present or not in perticular row.

               for(int i=0;i< board.length;++i){
                     if(board[i][rowAndcol[1]]==num && rowAndcol[0]!=i)
                            return false;
               }

           ///  Below code is use for checking the for num value present or not in 3x3 matrix.

            int row=rowAndcol[0]/3;
            int col= rowAndcol[1]/3;

               for(int i=row*3;i<row+3;++i){
                   for(int j=col*3;j<col+3;++j){
                       if(board[i][j]==num &&(i!=rowAndcol[0] && j!=rowAndcol[1]))
                           return false;
                   }
               }

              return true;
         }

    //// This function iis use for finding the empty box in the sudoku board.

      public static int[] findEmpty(int board[][]){
         int rowAndcol[]=new int[2];
            rowAndcol[0]=-1;
          rowAndcol[1]=-1;

            for(int i=0;i<board.length;++i){
                for(int j=0;j< board[0].length;++j){
                      if(board[i][j]==0){
                          rowAndcol[0]= i;
                          rowAndcol[1]=j;
                          return rowAndcol;
                      }
                }
            }
              return rowAndcol;
      }



//// This function iss use to print the SUKODU.

     public static void sudokuPrint(int board[][]){

          for(int i=0;i< board.length;++i){

              if(i%3==0 && i!=0)
                  System.out.println("-------------------");
              for(int j=0;j<board[0].length;++j){

                  if(j%3==0 && j!=0)
                      System.out.print("|");
                       System.out.print(board[i][j]+" ");
              }
              System.out.println();
          }
     }

}
