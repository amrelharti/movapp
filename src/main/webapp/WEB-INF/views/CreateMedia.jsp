<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Media Creation</title>
</head>
<body>
<header>
    <h1>Media Creation</h1>
</header>
<main>
    <form action="saveMedia" method="post">
        <div>
            <label for="title">Title : </label>
            <input type="text" id="title" name="title">
        </div>
        <div>
            <label for="description">Description : </label>
            <input type="text" id="description" name="description">
        </div>
        <div>
            <label for="release_d">Release Date : </label>
            <input type="date" id="release_d" name="release_date">
        </div>
        <div>
            <label for="rating">Rating : </label>
            <input type="number" id="rating" name="rating">
        </div>
        <div>
            <input type="submit" value="Save">
        </div>
    </form>
</main>
<footer>
    <a href="movieList">Movies List</a>
</footer>
</body>
</html>

