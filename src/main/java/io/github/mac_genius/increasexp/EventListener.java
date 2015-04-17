package io.github.mac_genius.increasexp;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;

/**
 * Listens for events and executes an action.
 */
public class EventListener implements Listener {

    /**
     * Executes an action when an entity dies.
     * @param event is the entity dying.
     */
    @EventHandler
    public synchronized void onEntityDeathEvent(EntityDeathEvent event) {
        if (event.getEntity().getKiller() != null) {
            Player player = event.getEntity().getKiller();
            if (player.hasPermission("shadexp.more")) {
                if (event.getEntity().getKiller().getInventory().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS) != 0) {
                    int lootingLevel = event.getEntity().getKiller().getInventory().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_MOBS);
                    double droppedXp = event.getDroppedExp();
                    droppedXp *= (1 + (lootingLevel / 5.0) + (Math.pow(lootingLevel, 2.0) / 10) + (Math.random() * .5 - .2));
                    droppedXp *= .8;
                    event.setDroppedExp((int) droppedXp);
                }
            }
        }
    }
    /**
     * Executes an action when a block is broken.
     * @param event is the block breaking.
     */
    @EventHandler
    public synchronized void onBlockBreakEvent(BlockBreakEvent event) {
        if (event.getPlayer() != null) {
            Player player = event.getPlayer();
            if (player.hasPermission("shadexp.more")) {
                int fortuneLevel = event.getPlayer().getInventory().getItemInHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
                double droppedXp = event.getExpToDrop();
                droppedXp *= (1 + (fortuneLevel / 5.0) + (Math.pow(fortuneLevel, 2.0) / 10) + (Math.random() * .5 - .2));
                droppedXp *= .8;
                event.setExpToDrop((int) droppedXp);
            }
        }
    }
}
