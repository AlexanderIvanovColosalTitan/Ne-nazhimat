Python 3.10.7 (tags/v3.10.7:6cc6b13, Sep  5 2022, 14:08:36) [MSC v.1933 64 bit (AMD64)] on win32
Type "help", "copyright", "credits" or "license()" for more information.
>>> import math
... x = 3.981*10**-2
... y = -1.625*10**3
... z = 0.512
... s = 2**-x * math.sqrt(x + abs(y)**(1./4.)) * (math.exp(x-1/math.sin(z)))**(1./3.)
