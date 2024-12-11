#include <stdio.h>
#include <math.h>

// Define a struct for a 2D point using typedef
typedef struct {
    float x;
    float y;
} Point;

// Function to calculate the distance between two points
float calculateDistance(Point p1, Point p2) {
    return sqrt(pow(p2.x - p1.x, 2) + pow(p2.y - p1.y, 2));
}

int main() {
    Point point1, point2; // Declare two points

    // Input coordinates for the first point
    printf("Enter coordinates for Point 1 (x y):  ");
    scanf("%f %f", &point1.x, &point1.y);

    // Input coordinates for the second point
    printf("Enter coordinates for Point 2 (x y): ");
    scanf("%f %f", &point2.x, &point2.y);

    // Calculate and display the distance
    float distance = calculateDistance(point1, point2);
    printf("\nPoint 1: (%.2f, %.2f)\n", point1.x, point1.y);
    printf("Point 2: (%.2f, %.2f)\n", point2.x, point2.y);
    printf("Distance between Point 1 and Point 2: %.2f\n", distance);

    return 0;
}
