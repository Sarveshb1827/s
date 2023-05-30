#include<stdio.h>
#include<mpi.h>
#define ARRAY_SIZE 10

int main (int argc, char** argv)
{
	int rank,size;
	int array[ARRAY_SIZE] = {1,2,3,4,5,6,7,8,9,10};
	int lc = 0;
	int gc =0;
	MPI_Init(&argc,&argv);
	MPI_Comm_rank(MPI_COMM_WORLD,&rank);
	MPI_Comm_size(MPI_COMM_WORLD,&size);
	
	int chunk = ARRAY_SIZE/size;
	int rem = ARRAY_SIZE% size;
	int startindex,endindex;
	
	if(rank<rem){
		chunk = chunk +1;
		startindex = rank*chunk;
		endindex = startindex + chunk;
	}
	else{
		startindex = rank * chunk+rem;
		endindex = startindex + chunk;
	}
	printf("process %d received array element: ",rank);
	for(int i=startindex;i<endindex;i++){
		printf("%d ",array[i]);
		lc = lc + array[i];
	}
	printf("= %d ",lc);
	printf("\n");
	MPI_Reduce(&lc,&gc,1,MPI_INT,MPI_SUM,0,MPI_COMM_WORLD);
	
	if(rank == 0){
		printf("Global Sum of array is : %d\n",gc);
	}
	MPI_Finalize();
	return 0;
}
