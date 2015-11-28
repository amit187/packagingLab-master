# PackagingLab 


There are couple of possible solutions.

1. Heauristic 
	This approach selects the next item to be added based on highest (cost / weight) value.
	It takes N iterations to solve the problem with this way. However the solution is not always optimal. It would be near Optimal.


2. Recursive
	Here all possible combination is formed and computed and the combination with highest cost is selected.
	It takes 2 ^ N - 1 iterations to solve the problem with this way. However the solution is guaranteed to be optimal.
	
	In our implementation, at every stage, the recursive is spanned in two branches 1. If we retain the current item in our solution. 2. If we do not retain the current item in our solution. 1 & 2 will be compared and the highest cost solution is returned. If there is a tie, the total weight is checked to see which one has the lowest weight.