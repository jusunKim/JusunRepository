import numpy as np
            # 0 1 2  3 4
a = np.array([2,1,10,6,3])
b = np.argsort(a)
# 1 2 3 6 10
print(b) #[1 0 4 3 2]
print(list(reversed(b))) #[2, 3, 4, 0, 1]