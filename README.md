two code examples in java, consisting on multithreading. the first one is matrix multiplication. the matrices are created randomly according to command line size arguments.
every vector multiplication leading to a cell in the final matrix is calculated be a different thread. the threads sync toghether in the end to print the final matrix to the terminal, using a monitor object.
the second example is a code destined  to sum an array. An array is created randomly, and every thread removes two elements from the array and returns their sum, and so on until the 
whole array sum is calculated to one number.
