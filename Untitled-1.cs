public int FindNextLarger(int[] arr)
{
	int max = arr[0];
	int nextMax=  0;
	
	int i = 1;
	while (i < arr.Length)
	{
		if ((max < arr[i]))
		{
			nextMax = max;
			max = arr[i];
		}
		i++;
	}
	
	return nextMax;
}

public void main()
{
	FindNextLarger();
}

