package com.github.justasbieliauskas.rmvm.cpu;

import com.github.justasbieliauskas.rmvm.data.Id;

import java.util.Map;

/**
 * First non-empty processor out of collection of processors
 * or empty processor if all processors are empty.
 *
 * @author Justas Bieliauskas
 */
public class FirstNonEmptyCPU implements UnsafeNewCPUWithId
{
    private final UnsafeNewCPUWithId[] processors;

    /**
     * @param processors conditional processors
     */
    public FirstNonEmptyCPU(UnsafeNewCPUWithId... processors) {
        this.processors = processors;
    }

    @Override
    public Map<String, Long> toMap() throws Exception {
        Map<String, Long> registers = null;
        for(int i = 0; i != this.processors.length; i++) {
            try {
                registers = this.processors[i].toMap();
            } catch (Exception e) {
                throw new Exception(
                    String.format(
                        "Failed to convert %d processor to map in FirstNonEmptyCPU",
                        i
                    ),
                    e
                );
            }
            if(!registers.isEmpty()) {
                break;
            }
        }
        return registers;
    }

    @Override
    public UnsafeNewCPUWithId with(CPU processor, Id id) {
        UnsafeNewCPUWithId[] processors = new UnsafeNewCPUWithId[this.processors.length];
        for(int i = 0; i != processors.length; i++) {
            processors[i] = this.processors[i].with(processor, id);
        }
        return new FirstNonEmptyCPU(processors);
    }
}
