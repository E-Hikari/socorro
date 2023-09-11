import React from "react";

export const nodes = [
  {
    id: "1",
    type: "input",
    data: {
      label: (
        <>
          Tank
        </>
      )
    },
    position: { x: 250, y: 0 },
    style: {
      background: "#00b9a4",
      color: "#333",
      border: "1px solid #222138",
      width: 180
    }
  },
  {
    id: "2",
    data: {
      label: (
        <>
          MixProof
        </>
      )
    },
    position: { x: 100, y: 100 },
    style: {
      background: "#ff465b",
      color: "#333",
      border: "1px solid #222138",
      width: 180
    }
  },
  {
    id: "3",
    data: {
      label: (
        <>
          Mixproof
        </>
      )
    },
    position: { x: 400, y: 100 },
    style: {
      background: "#ff465b",
      color: "#333",
      border: "1px solid #222138",
      width: 180
    }
  },
  {
    id: "4",
    position: { x: 250, y: 200 },
    data: {
      label: "Solenoide"
    },
    style: {
      background: "#46e9ff",
      color: "#333",
      border: "1px solid #222138",
      width: 180
    }
  },
  {
    id: "5",
    data: {
      label: "MixProof"
    },
    position: { x: 250, y: 325 },
    style: {
      background: "#ff465b",
      color: "#333",
      border: "1px solid #222138",
      width: 180
    }
  },
  {
    id: "6",
    type: "output",
    data: {
      label: (
        <>
          MixProof
        </>
      )
    },
    position: { x: 100, y: 480 },
    style: {
      background: "#ff465b",
      color: "#333",
      border: "1px solid #222138",
      width: 180
    }
  },
  {
    id: "7",
    type: "output",
    data: { label: "Tank" },
    position: { x: 400, y: 450 },
    style: {
      background: "#00b9a4",
      color: "#333",
      border: "1px solid #222138",
      width: 180
    }
  }
];

export const edges = [
  { id: "e1-2", source: "1", target: "2", animated: true, label: "ROTA" },
  { id: "e1-3", source: "1", target: "3", animated: true, label: "ROTA" },
  { id: "e3-4", source: "3", target: "4", animated: true, label: "ROTA" },
  { id: "e4-5", source: "4", target: "5", animated: true, label: "ROTA" },
  { id: "e5-6", source: "5", target: "6", animated: true, label: "ROTA" },
  { id: "e5-7", source: "5", target: "7", animated: true, label: "ROTA"}
];
