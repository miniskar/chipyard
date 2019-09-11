package example

import chisel3._

import freechips.rocketchip.config.{Config}

// --------------
// Rocket Configs
// --------------

class RocketConfig extends Config(
  new WithTop ++                                           // use default top
  new WithBootROM ++                                       // use default bootrom
  new freechips.rocketchip.subsystem.WithInclusiveCache ++ // use Sifive L2 cache
  new freechips.rocketchip.subsystem.WithNBigCores(1) ++   // single rocket-core
  new freechips.rocketchip.system.BaseConfig)              // "base" rocketchip system

class HwachaRocketConfig extends Config(
  new WithTop ++
  new WithBootROM ++
  new freechips.rocketchip.subsystem.WithInclusiveCache ++
  new hwacha.DefaultHwachaConfig ++                        // use Hwacha vector accelerator
  new freechips.rocketchip.subsystem.WithNBigCores(1) ++
  new freechips.rocketchip.system.BaseConfig)

class RoccRocketConfig extends Config(
  new WithTop ++
  new WithBootROM ++
  new freechips.rocketchip.subsystem.WithInclusiveCache ++
  new freechips.rocketchip.subsystem.WithRoccExample ++    // use example RoCC-based accelerator
  new freechips.rocketchip.subsystem.WithNBigCores(1) ++
  new freechips.rocketchip.system.BaseConfig)

class jtagRocketConfig extends Config(
  new WithDTMTop ++                                        // use top with dtm
  new freechips.rocketchip.subsystem.WithJtagDTM ++        // add jtag/DTM module to coreplex
  new WithBootROM ++
  new freechips.rocketchip.subsystem.WithInclusiveCache ++
  new freechips.rocketchip.subsystem.WithNBigCores(1) ++
  new freechips.rocketchip.system.BaseConfig)

class PWMRocketConfig extends Config(
  new WithPWMTop ++                                        // use top with tilelink-controlled PWM
  new WithBootROM ++
  new freechips.rocketchip.subsystem.WithInclusiveCache ++
  new freechips.rocketchip.subsystem.WithNBigCores(1) ++
  new freechips.rocketchip.system.BaseConfig)

class PWMRAXI4ocketConfig extends Config(
  new WithPWMAXI4Top ++                                    // use top with axi4-controlled PWM
  new WithBootROM ++
  new freechips.rocketchip.subsystem.WithInclusiveCache ++
  new freechips.rocketchip.subsystem.WithNBigCores(1) ++
  new freechips.rocketchip.system.BaseConfig)

class SimBlockDeviceRocketConfig extends Config(
  new testchipip.WithBlockDevice ++                        // add block-device module to peripherybus
  new WithSimBlockDeviceTop ++                             // use top with block-device IOs and connect to simblockdevice
  new WithBootROM ++
  new freechips.rocketchip.subsystem.WithInclusiveCache ++
  new freechips.rocketchip.subsystem.WithNBigCores(1) ++
  new freechips.rocketchip.system.BaseConfig)

class BlockDeviceModelRocketConfig extends Config(
  new testchipip.WithBlockDevice ++                        // add block-device module to periphery bus
  new WithBlockDeviceModelTop ++                           // use top with block-device IOs and connect to a blockdevicemodel
  new WithBootROM ++
  new freechips.rocketchip.subsystem.WithInclusiveCache ++
  new freechips.rocketchip.subsystem.WithNBigCores(1) ++
  new freechips.rocketchip.system.BaseConfig)

class GPIORocketConfig extends Config(
  new WithGPIO ++                                          // add GPIOs to the peripherybus
  new WithGPIOTop ++                                       // use top with GPIOs
  new WithBootROM ++
  new freechips.rocketchip.subsystem.WithInclusiveCache ++
  new freechips.rocketchip.subsystem.WithNBigCores(1) ++
  new freechips.rocketchip.system.BaseConfig)

class DualCoreRocketConfig extends Config(
  new WithTop ++
  new WithBootROM ++
  new freechips.rocketchip.subsystem.WithInclusiveCache ++
  new freechips.rocketchip.subsystem.WithNBigCores(2) ++   // dual-core (2 RocketTiles)
  new freechips.rocketchip.system.BaseConfig)

class RV32RocketConfig extends Config(
  new WithTop ++
  new WithBootROM ++
  new freechips.rocketchip.subsystem.WithInclusiveCache ++
  new freechips.rocketchip.subsystem.WithRV32 ++           // set RocketTiles to be 32-bit
  new freechips.rocketchip.subsystem.WithNBigCores(1) ++
  new freechips.rocketchip.system.BaseConfig)

class GB1MemoryRocketConfig extends Config(
  new WithTop ++
  new WithBootROM ++
  new freechips.rocketchip.subsystem.WithInclusiveCache ++
  new freechips.rocketchip.subsystem.WithExtMemSize((1<<30) * 1L) ++ // use 2GB simulated external memory
  new freechips.rocketchip.subsystem.WithNBigCores(1) ++
  new freechips.rocketchip.system.BaseConfig)

class LoopbackNICRocketConfig extends Config(
  new WithIceNIC ++
  new WithLoopbackNICTop ++
  new RocketConfig)

class RemoteMemClientRocketConfig extends Config(
  new WithIceNIC ++
  new WithRemoteMemClient(1024) ++
  new WithMemBlade(Some(1024)) ++
  new WithRemoteMemClientTop ++
  new RocketConfig)

class DRAMCacheRocketConfig extends Config(
  new WithIceNIC ++
  new WithDRAMCache(
    sizeKB = 112,
    nTrackersPerBank = 4,
    nBanksPerChannel = 2) ++
  new WithMemBlade ++
  new WithPrefetchRoCC ++
  new WithDRAMCacheTop ++
  new RocketConfig)

class Sha3RocketConfig extends Config(
  new sha3.WithSha3Accel ++                                // add SHA3 rocc accelerator
  new WithTop ++
  new WithBootROM ++
  new freechips.rocketchip.subsystem.WithInclusiveCache ++
  new freechips.rocketchip.subsystem.WithNBigCores(1) ++
  new freechips.rocketchip.system.BaseConfig)