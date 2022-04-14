let $map = document.querySelector("#map");
let geocoder = L.Control.Geocoder.nominatim();

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
        geocoder: geocoder,
        lineOptions: {
          styles: [
            {
              color: "#839c49",
              opacity: 1,
              weight: 7,
            },
          ],
        },
        waypoints: [L.latLng(48.856614, 2.3522219), L.latLng(43.604, 1.44305)],
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
//console.log(document.querySelector("#depart").innerHTML);

//let waypoints = [];

function latLngDepart(ville) {
  const lat = 0;
  var end_lat = 0;
  var end_lng = 0;
  geocoder.geocode(ville, function (a) {
    // depending on geocoder results may be either in a or b
    console.log(a);
    // choose the best result here. probably the first one in array
    // create waypoint object
    console.log(a[0].center.lat);
    localStorage.setItem("endlat", a[0].center.lat);
    localStorage.setItem("endlng", a[0].center.lng);
    console.log("après 2 " + localStorage.getItem("endlat"));
  });
  end_lat = localStorage.getItem("endlat");
  end_lng = localStorage.getItem("endlng");

  return [end_lat, end_lng];
}

var test;
var test2;
function latLngArrivee(ville) {
  const lat = 0;
  var end_lat = 0;
  var end_lng = 0;

  geocoder.geocode(ville, function (a) {
    //localStorage.removeItem("endlatA");

    //localStorage.removeItem("endlngA");
    // depending on geocoder results may be either in a or b
    console.log(a);
    // choose the best result here. probably the first one in array
    // create waypoint object
    console.log(a[0].center.lat);
    localStorage.setItem("endlatA", a[0].center.lat);
    test = a[0].center.lat;
    test2 = a[0].center.lng;
    localStorage.setItem("endlngA", a[0].center.lng);
    console.log("après 2 " + localStorage.getItem("endlatA"));
    return test;
  });

  console.log("test " + test);
  end_lat = localStorage.getItem("endlatA");
  end_lng = localStorage.getItem("endlngA");
  console.log("localStorage avant :" + localStorage.getItem("endlatA"));

  localStorage.removeItem("endlatA");
  localStorage.removeItem("endlngA");
  console.log("localStorage après :" + localStorage.getItem("endlatA"));

  return [end_lat, end_lng];
}

function latLngEtape(ville) {
  const lat = 0;
  var end_lat = 0;
  var end_lng = 0;
  geocoder.geocode(ville, function (a) {
    // depending on geocoder results may be either in a or b
    console.log(a);
    // choose the best result here. probably the first one in array
    // create waypoint object
    console.log(a[0].center.lat);
    localStorage.setItem("endlatEtape", a[0].center.lat);
    localStorage.setItem("endlngEtape", a[0].center.lng);
    console.log("après 2 " + localStorage.getItem("endlatEtape"));
  });
  end_lat = localStorage.getItem("endlatEtape");
  end_lng = localStorage.getItem("endlngEtape");

  return [end_lat, end_lng];
}

export { latLngDepart, latLngArrivee, latLngEtape };

// setting waypoints
