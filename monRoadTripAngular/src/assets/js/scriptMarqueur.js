let $map = document.querySelector("#map");

class LeafletMap {
  constructor() {
    this.map = null;
    this.bounds = [];
  }
  async load(element) {
    return new Promise((resolve, reject) => {
      this.map = L.map(element).setView([51.505, -0.09], 13);
      L.tileLayer("https://{s}.tile.openstreetmap.fr/osmfr/{z}/{x}/{y}.png", {
        attribution:
          '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
        maxZoom: 18,
        tileSize: 512,
        zoomOffset: -1,
      }).addTo(this.map);
      //On active la gestion d'itinéraires
      L.Routing.control({
        geocoder: L.Control.Geocoder.nominatim(),
        lineOptions: {
          styles: [
            {
              color: "#839c49",
              opacity: 1,
              weight: 7,
            },
          ],
        },
        router: new L.Routing.osrmv1({
          language: "fr",
          profile: "car", //car, bike
        }),
      }).addTo(this.map);
      resolve();
    });
  }

  addMarker(lat, lng, text) {
    let point = [lat, lng];
    this.bounds.push(point);
    return new LeafletMarker(point, text, this.map);
  }

  center() {
    this.map.fitBounds(this.bounds);
  }
}

class LeafletMarker {
  constructor(point, text, map) {
    this.popup = L.popup({
      autoClose: false,
      closeOnEscapeKey: false,
      closeOnClick: false,
      classeName: "marker",
      maxWidth: 400,
    })
      .setLatLng(point)
      .setContent(text)
      .openOn(map);
  }

  setActive() {
    this.popup.getElement().classList.add("is-active");
  }

  unsetActive() {
    this.popup.getElement().classList.remove("is-active");
  }

  addEventListener(event, cb) {
    this.popup.addEventListener("add", () => {
      this.popup.getElement().addEventListener(event, cb);
    });
  }

  setContent(text) {
    this.popup.setContent(text);
    this.popup.update();
  }
}

const initMap = function () {
  let map = new LeafletMap();
  let hoverMarker = null;
  map.load($map);
  Array.from(document.querySelectorAll(".js-marker")).forEach((item) => {
    let marker = map.addMarker(
      item.dataset.lat,
      item.dataset.lng,
      item.dataset.price + " €"
    );
    item.addEventListener("mouseover", function () {
      if (hoverMarker !== null) {
        hoverMarker.unsetActive();
      }
      marker.setActive();
      hoverMarker = marker;
    });
    item.addEventListener("mouseleave", function () {
      if (hoverMarker !== null) {
        hoverMarker.unsetActive();
      }
    });
    marker.addEventListener("click", function () {
      marker.setContent(item.innerHTML);
    });
  });
  map.center();
};

if ($map !== null) {
  initMap();
}
console.log(document.querySelector("#depart").innerHTML);
