package com.company.isobserve.controller;

import com.company.isobserve.dto.NodeDetailsDto;
import com.company.isobserve.dto.NodeSummaryDto;
import com.company.isobserve.entity.Node;
import io.jmix.core.DataManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class NodeController {

    private final DataManager dataManager;

    public NodeController(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    // --- /api/nodes ---
    @GetMapping("/nodes")
    public List<NodeSummaryDto> getNodes() {
        List<Node> nodes = dataManager.load(Node.class)
                .all()
                .list();

        return nodes.stream()
                .map(n -> new NodeSummaryDto(
                        n.getId().toString(),
                        n.getName(),
                        n.getStatus() != null ? n.getStatus().name() : null,
                        n.getProblemLevel()
                ))
                .collect(Collectors.toList());
    }

    // --- /api/node/{id} ---
    @GetMapping("/node/{id}")
    public ResponseEntity<NodeDetailsDto> getNodeById(@PathVariable UUID id) {
        Node n = dataManager.load(Node.class)
                .id(id)
                .optional()
                .orElse(null);

        if (n == null) {
            return ResponseEntity.notFound().build();
        }

        NodeDetailsDto dto = new NodeDetailsDto(
                n.getId().toString(),
                n.getName(),
                n.getStatus() != null ? n.getStatus().name() : null,
                n.getProblemLevel(),
                n.getIpAddress(),
                n.getLocationLat(),
                n.getLocationLon(),
                n.getZabbixServer() != null ? n.getZabbixServer().getName() : null
        );

        return ResponseEntity.ok(dto);
    }
}
