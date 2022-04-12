// On s'assure que la page est chargée
window.onload = function () {
  //On initialise la carte sur les coordonnées GPS de Paris
  let macarte = L.map("carte").setView([48.852969, 2.349903], 5);

  // On charge les tuiles de la carte depuis un serveur au choix, ici OpenStreetMap France
  L.tileLayer("https://{s}.tile.openstreetmap.fr/osmfr/{z}/{x}/{y}.png", {
    attribution: "données openstreetmap France",
    minZoom: 1,
    maxZoom: 20,
  }).addTo(macarte);

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
  }).addTo(macarte);
};
