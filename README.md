# PixelInRadiusFinder
These are a set of algorithms meant to find all the (integer) points centered around a specific vertex and within a given radius.
There is a benchmarking class to compare the speeds of each algorithm.
There are four algorithms so far:
- Naive Radius Checking (NRC): NRC checks all points within the circle's AABB and see's if they are within the circle's radius. 
- Partial Sub-Division Radius Checking (PSD-RC): This is similar to NRC, but only a quarter of the AABB is checked. And any valid points that are found, are just mirrored 3 times through basic transformations. 
- Partial Sub-Division Solver (PSDS): PSDS is the algorithm that started this all. It's easier to explain with a beautifully drawn diagram (with Paint, ofc).

![PSDS circle](http://i.imgur.com/ilwaA3o.png)

- First, the algorithm finds all points within the central red square. Then, it computes the points in 1 of the blue semi-semi circles, and mirrors them 7 times without repeating the harder calculations. 
- Full Sub-Division Solver (FSDS): An improvement over PSDS and the fastest algorithm in benchtests. It is very similar to PSDS, except for in the beginning when the central red square is divided into 4 quarters, and only the points in 1 quarter are computed. The rest just being mirrored. 

