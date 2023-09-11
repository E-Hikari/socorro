import React, { useState, useCallback, useRef } from "react";
import ReactFlow, {
  addEdge,
  MiniMap,
  Controls,
  Background,
  useNodesState,
  useEdgesState,
  updateEdge,
  useReactFlow,
  Panel,
  ReactFlowProvider,
} from "reactflow";
import "reactflow/dist/style.css";
import "../styles.css";
import Navbar from "../components/Navbar";
import api from "../services/api";

import ProcessLibrary from "../components/ProcessLibrary";

import {
  nodes as initialNodes,
  edges as initialEdges,
} from "../components/initial-elements";

const flowKey = "example-flow";

const getNodeId = () => "New Node";

function downloadImage(dataUrl) {
  const a = document.createElement("a");

  a.setAttribute("download", "reactflow.png");
  a.setAttribute("href", dataUrl);
  a.click();
}

const SaveRestore = () => {
  const reactFlowWrapper = useRef(true);
  const edgeUpdateSuccessful = useRef(true);
  const [nodes, setNodes, onNodesChange] = useNodesState(initialNodes);
  const [edges, setEdges, onEdgesChange] = useEdgesState(initialEdges);
  const [rfInstance, setRfInstance] = useState(null);
  const onConnect = useCallback(
    (params) => setEdges((els) => addEdge(params, els)),
    []
  );

  const { setViewport } = useReactFlow();
  const onEdgeUpdateStart = useCallback(() => {
    edgeUpdateSuccessful.current = false;
  }, []);

  const getId = () => `dndode_${+new Date()}`;
  const onEdgeUpdate = useCallback((oldEdge, newConnection) => {
    edgeUpdateSuccessful.current = true;
    setEdges((els) => updateEdge(oldEdge, newConnection, els));
  }, []);

  const onEdgeUpdateEnd = useCallback((_, edge) => {
    if (!edgeUpdateSuccessful.current) {
      setEdges((eds) => eds.filter((e) => e.id !== edge.id));
    }

    edgeUpdateSuccessful.current = true;
  }, []);
  const onInit = (reactFlowInstance) => {
    setRfInstance(reactFlowInstance);
    console.log("flow loaded:", reactFlowInstance);
  };

  const onAddM = useCallback(() => {
    const id = getNodeId();
    const newNode = {
      id: id,
      data: { label: "MixProof" },
      position: {
        x: 100,
        y: 200,
      },
      style: {
        background: "#ff465b",
        color: "#333",
        border: "1px solid #222138",
        width: 180,
      },
    };
    setNodes((nds) => nds.concat(newNode));
  }, [setNodes]);

  const onAddT = useCallback(() => {
    const id = getNodeId();
    const newNode = {
      id: id,
      data: { label: "Tank" },
      position: {
        x: 100,
        y: 200,
      },
      style: {
        background: "#00b9a4",
        color: "#333",
        border: "1px solid #222138",
        width: 180,
      },
    };
    useEffect(() => {
      api
        .post("http://localhost:8080/tank", {
          name: "Left4Dead",
          status: "alive",
          location: "heaven",
          condition: "bad",
          way: "upright",
        })
        .then((res) => {
          console.log("Sua requisição foi um sucesso: ", res);
          setNodes((nds) => nds.concat(newNode));
        })
        .catch((err) => {
          console.log("ops! ocorreu um erro: ", err);
        });
    }, []);
  }, [setNodes]);

  const onAddS = useCallback(() => {
    const id = getNodeId();
    const newNode = {
      id: id,
      data: { label: "Solenoide" },
      position: {
        x: 100,
        y: 200,
      },
      style: {
        background: "#46e9ff",
        color: "#333",
        border: "1px solid #222138",
        width: 180,
      },
    };
    setNodes((nds) => nds.concat(newNode));
  }, [setNodes]);

  const onDragOver = useCallback((event) => {
    event.preventDefault();
    event.dataTransfer.dropEffect = "move";
  }, []);

  const onDrop = useCallback(
    (event) => {
      event.preventDefault();

      const reactFlowBounds = reactFlowWrapper.current.getBoundingClientRect();
      const type = event.dataTransfer.getData("application/reactflow");

      // check if the dropped element is valid
      if (typeof type === "undefined" || !type) {
        return;
      }

      const position = rfInstance.project({
        x: event.clientX - reactFlowBounds.left,
        y: event.clientY - reactFlowBounds.top,
      });
      const newNode = {
        id: getId(),
        type,
        position,
        data: { label: `${type} node` },
      };

      setNodes((nds) => nds.concat(newNode));
    },
    [rfInstance]
  );

  return (
    <div className="reactflow-wrapper" ref={reactFlowWrapper}>
      <ReactFlow
        nodes={nodes}
        edges={edges}
        onNodesChange={onNodesChange}
        onEdgesChange={onEdgesChange}
        onEdgeUpdate={onEdgeUpdate}
        onEdgeUpdateStart={onEdgeUpdateStart}
        onEdgeUpdateEnd={onEdgeUpdateEnd}
        onConnect={onConnect}
        onInit={setRfInstance}
        onDrop={onDrop}
        onDragOver={onDragOver}
        fitView
        attributionPosition="top-right"
      >
        <MiniMap
          nodeStrokeColor={(n) => {
            if (n.style?.background) return n.style.background;
            if (n.type === "input") return "#0041d0";
            if (n.type === "output") return "#ff0072";
            if (n.type === "default") return "#1a192b";

            return "#eee";
          }}
          nodeColor={(n) => {
            if (n.style?.background) return n.style.background;

            return "#fff";
          }}
          nodeBorderRadius={2}
        />
        <Controls />
        <Background color="#aaa" gap={16} />
        <Panel position="bottom-center">
          <button onClick={onAddT}>Tank</button>
          <button onClick={onAddM}>Mixproof</button>
          <button onClick={onAddS}>Solenoide</button>
        </Panel>
      </ReactFlow>
    </div>
  );
};
export default () => (
  <div className="dndflow">
    <Navbar />
    <ReactFlowProvider>
      <SaveRestore />
    </ReactFlowProvider>
    <ProcessLibrary />
  </div>
);
