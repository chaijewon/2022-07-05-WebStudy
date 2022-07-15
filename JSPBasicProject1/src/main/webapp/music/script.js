function init() {
  // listType: top_rated, popular, now_playing, latest, upcoming
  function requestHandler({
    method = "GET",
    pageNumber = 1,
    listType = "popular" })
  {
    return new Promise((resolve, reject) => {
      var request = new XMLHttpRequest();
      request.open(
      method,
      `https://api.themoviedb.org/3/movie/${listType}?api_key=4bef8838c2fd078bd13d7127d8dedcd4&language=en-US&page=${pageNumber}`);

      request.setRequestHeader(
      "Content-type",
      "application/json; charset=utf-8");

      request.addEventListener("load", handleDataLoad, false);
      request.addEventListener("error", handleError, false);
      request.send();

      function handleError(event) {
        reject("The resquest has been rejected");
      }

      function handleDataLoad(event) {
        resolve({
          listType,
          res: JSON.parse(event.target.response) });

      }
    });
  }
  function crtEle(elementName, text, attribute = {}) {
    const newEle = document.createElement(elementName);
    Object.keys(attribute).forEach(key => {
      newEle.setAttribute(key, attribute[key]);
    });

    if (!!text) {
      newEle.innerHTML = text;
    }

    return newEle;
  }
  function getFormatedDate(date, format) {
    return moment(date).format(format);
  }
  const savedLikedList = [];
  const headerCopy = {
    popular: "The most popular movies" };

  const switchTabs = document.querySelector("#switch-tab");
  const movieList = document.querySelector("#movie-list");
  const likedList = document.querySelector("#liked-list");
  const listHeading = document.querySelector("#movies-list__heading");
  const BASE_IMG_URL = "https://image.tmdb.org/t/p/w500/";

  requestHandler({ method: "GET" }).then(data => {
    listHeading.innerHTML = headerCopy[data.listType];

    data.res.results.forEach((movie, index) => {
      const movieCard = crtEle("div", null, {
        class: "movie_card",
        id: movie.id,
        "data-id": movie.id,
        "data-index": index,
        "data-movie-card": "",
        'data-title': movie.title });

      const img = crtEle("img", null, {
        alt: movie.title,
        src: BASE_IMG_URL + movie.poster_path,
        class: "movie_card_poster",
        width: 200,
        height: 300 });

      const title = crtEle("h3", movie.title, {
        class: "movie_card_title" });

      const formattedDate = getFormatedDate(movie.release_date, "MMM D, YYYY");
      const releaseDate = crtEle("div", formattedDate, {
        class: "movie_card_release-date" });

      const actionsSection = crtEle('section', null, {
        class: 'movie_card_actions_sec' });

      const like = crtEle('a', 'Like It!', {
        class: 'movie_card_action_like',
        href: 'javascript:void(0)' });

      const dislike = crtEle('a', 'Hate It!', {
        class: 'movie_card_action_dislike',
        href: 'javascript:void(0)' });


      if (!!savedLikedList.find(({ id }) => id === movie.id)) {
        like.classList.add('liked');
      }

      actionsSection.appendChild(like);

      movieCard.appendChild(img);
      movieCard.appendChild(title);
      movieCard.appendChild(releaseDate);
      movieCard.appendChild(actionsSection);
      movieList.appendChild(movieCard);
    });
  });

  document.querySelectorAll("div.tab").forEach(function (tab) {
    tab.addEventListener("click", function (event) {
      Array.from(switchTabs.children).forEach(child => {
        child.classList.remove("selected");
      });
      event.target.classList.add("selected");
    });
  });

}

document.addEventListener("DOMContentLoaded", init);