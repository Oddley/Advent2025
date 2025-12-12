package Day11;

import Common.FIterable;

public record Device(String Name, FIterable<String> Outputs) {
    @Override
    public String toString() {
        return new StringBuilder().append(Name).append("->").append(String.join(",",Outputs)).toString();
    }
}
