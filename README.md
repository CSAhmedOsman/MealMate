# MealMate

MealMate is a comprehensive Android mobile application designed to revolutionize meal planning and cooking experiences. With MealMate, users can explore a diverse range of recipes from various cuisines, plan their weekly meals efficiently, and synchronize their data for seamless access across devices.

## Features

- **Meal of the Day**: Get inspired with a daily featured meal.
- **Search**: Effortlessly find meals by country, ingredient, or category.
- **Categories and Countries**: Browse through lists of categories and popular meals from different countries.
- **Favorite Meals**: Save your favorite recipes for quick access.
- **Data Synchronization**: Backup and retrieve your data seamlessly.
- **Weekly Meal Planning**: Plan your meals for the week ahead.
- **Offline Access**: Access your favorite meals and meal plan even without an internet connection.
- **Authentication**: Simple login and sign-up options, including social networking authentication.
- **Guest Mode**: Explore limited functionality without signing up.
- **Detailed Meal Information**: View comprehensive details including name, image, country, ingredients, steps, and embedded videos.
- **Splash Screen with Animation**: Start your MealMate experience with an engaging splash screen animation.
- **Bonus: Add to Mobile Calendar**: Keep track of your meal plan by adding meals to your device's calendar.

## API Integration

MealMate seamlessly integrates with an external API to fetch comprehensive meal data, including ingredients, cooking instructions, images, and additional details. This integration ensures that you have access to a diverse range of high-quality recipes that cater to your individual tastes and preferences.

API: [TheMealDB API](https://themealdb.com/api.php)

### Sample API Response

Here's an example of the JSON response structure for a meal:

```json
{
    "meals": [
        {
            "idMeal": "52897",
            "strMeal": "Carrot Cake",
            // (Details omitted for brevity)
        }
    ]
}
```

## Dependencies

MealMate utilizes the following dependencies:

- Retrofit: for making API requests to TheMealDB API.
- Glide: for loading and caching images.
- Room: for local database storage.
- Firebase Authentication: for user authentication.
- Firebase Firestore: for data synchronization and backup.

## Support and Feedback

Your feedback is crucial in improving MealMate and making it more user-friendly.
Whether you have suggestions for new features, encounter bugs, or simply want to share your thoughts, we welcome and appreciate your input!

### How to Provide Feedback

Please follow these guidelines when providing feedback:

- **Be Specific**: Clearly describe the issue or suggestion.
- **Be Constructive**: Provide actionable suggestions for improvement.
- **Be Respectful**: Keep the tone polite and constructive.
- **Be Patient**: Understand that implementing changes may take time.

You can share your feedback by creating an issue in this GitHub repository or contacting us directly via:

- LinkedIn: [CSAhmedOsman](https://www.linkedin.com/in/csahmedosman)
- GitHub: [CSAhmedOsman](https://www.github.com/csahmedosman)

Thank you for using MealMate and helping make it better for everyone!
